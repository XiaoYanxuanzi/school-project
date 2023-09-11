<template>
  <div style="height: 100vh; display: flex; align-items: center; justify-content: center; background-color: rgba(120,43,215,0.65)" >
    <div style="display: flex; background-color: white; width: 55%; border-radius: 5px; overflow: hidden">
      <div style="flex: 1">
        <img src="@/assets/register.png" alt="" style="width: 100%">
      </div>
      <div style="flex: 1; display: flex; align-items: center; justify-content: center">
        <el-form style="width: 80%"  :model="user" :rules="rules" ref="registerRef">
          <div style="font-size: 20px; font-weight: bold; text-align: center; margin-bottom: 20px">课堂教学管理系统注册</div>
          <el-form-item prop="username">
            <el-input prefix-icon="el-icon-user" size="medium" v-model="user.username" placeholder="请输入账号"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input prefix-icon="el-icon-lock" size="medium" v-model="user.password" show-password placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-form-item prop="confirmPass">
            <el-input prefix-icon="el-icon-lock" size="medium" v-model="user.confirmPass" show-password placeholder="请确认密码"></el-input>
          </el-form-item>
          <el-form-item prop="role">
            <el-radio-group v-model="user.role">
              <el-radio label="学生"></el-radio>
              <el-radio label="老师"></el-radio>
              <el-radio label="辅导员"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" style="width: 100%" @click="register">注 册</el-button>
          </el-form-item>
          <div style="display: flex">
            <div style="flex: 1">已经有账号了？请  <a href="/login">登录</a></div>
          </div>
        </el-form>
      </div>
    </div>

  </div>
</template>

<script>

import request from "@/utils/request";

export default {
  name: "Register",
  data() {
    //二次密码校验
    const validatePassword = (rule, confirmPass, callback) => {
      if (confirmPass === '') {
        callback(new Error('请确认密码'))
      } else if (confirmPass !== this.user.password) {
        callback(new Error('两次输入的密码不一致'))
      } else {
        callback()
      }
    }

    return {
      user: {
        username: '',
        password: '',
        confirmPass: ''
      },
      rules: {
        username: [
          {required: true, message: '请输入账号', trigger: 'blur'},
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
        ],
        confirmPass: [
          {validator: validatePassword, trigger: 'blur'}
        ],
        role: [
          {required: true, message: '请选择角色', trigger: 'blur'},
        ],
      },
    }
  },


  methods: {
    register() {
      this.$refs["registerRef"].validate((valid) => {
        if (valid) {
          request.post('/role/register', this.user).then(res => {
            console.log(res)
            if (res.code === '200') {
              this.$router.push('/login')
              this.$message.success('注册成功')
            } else {
              this.$message.error(res.msg)
            }
          })
        }
      });
    }
  }
}

</script>

<style scoped>
a{
  color: #6e77f2;
  cursor: pointer;
  text-decoration: none;
}
</style>