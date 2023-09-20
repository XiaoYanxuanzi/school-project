<template>
  <div style="height: 100vh; display: flex; align-items: center; justify-content: center; background-color: #0f5d98">
    <div style="display: flex; background-color: white; width: 50%; border-radius: 5px; overflow: hidden">
      <div style="flex: 1">
        <img src="@/assets/login.png" alt="" style="width: 100%">
      </div>
      <div style="flex: 1; display: flex; align-items: center; justify-content: center">
        <el-form :model="user" :rules="rules" style="width: 80%" ref="loginRef">
          <div style="font-size: 20px; font-weight: bold; text-align: center; margin-bottom: 20px">课堂教学管理系统登录</div>
          <el-form-item prop="username">
            <el-input prefix-icon="el-icon-user" size="medium" placeholder="请输入账号" v-model="user.username"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input prefix-icon="el-icon-lock" size="medium" show-password placeholder="请输入密码" v-model="user.password"></el-input>
          </el-form-item>
          <el-form-item prop="code">
            <div style="display: flex">
              <el-input placeholder="请输入验证码" prefix-icon="el-icon-circle-check" size="medium" style="flex: 1" v-model="user.code"></el-input>
              <div style="flex: 1; height: 36px">
                <valid-code @update:value="getCode" />
              </div>
            </div>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" style="width: 100%" @click="login">登 录</el-button>
          </el-form-item>
          <div style="display: flex">
            <div style="flex: 1">还没有账号？请 <span style="color: #0f9876; cursor: pointer" @click="$router.push('/register')">注册</span></div>
            <div style="flex: 1; text-align: right"><span style="color: #0f9876; cursor: pointer">忘记密码</span></div>
          </div>
        </el-form>
      </div>
    </div>


    <el-dialog title="忘记密码"  width="30%">
      <el-form  label-width="80px" style="padding-right: 20px">
        <el-form-item label="用户名">
          <el-input  autocomplete="off" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input  autocomplete="off" placeholder="请输入手机号"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button >取 消</el-button>
        <el-button type="primary">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import ValidCode from "@/components/ValidCode";
import request from "@/utils/request";

export default {
  name: "Login",
  components: {
    ValidCode
  },
  data() {

    //验证码校验
    const validateCode = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入验证码'));
      } else if (value !== this.code){
        callback(new Error('验证码错误'));
      }else {
        callback();
      }
    };

    return {
      code: '',  // 验证码组件传递过来的code
      user: {
        code: '',   // 表单里用户输入的code 验证码
        username: '',
        password: ''
      },
      rules:{
        username: [
          { required: true, message: '请输入账号', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        code:[
          { validator: validateCode, trigger: 'blur' }
        ]
      },
    }
  },
  created() {

  },
  methods: {

    getCode(code) {
      console.log(code)
      this.code = code.toLowerCase()//变成小写
    },
    login() {
      this.$refs["loginRef"].validate((valid) => {
        if (valid) {
          request.post('/student/login',this.user).then(res => {
            // console.log('res.code:', res.code);
            // console.log('res.data.role:', res.data.role);
            if (res.code === '200'){
              this.$router.push('/front/home')
              this.$message.success('登录成功')
              localStorage.setItem("student", JSON.stringify(res.data))  // 存储用户数据
            }else {
              this.$message.success(res.msg)
            }
          })
        }
      });
    }
  }
}
</script>

<style scoped>

</style>