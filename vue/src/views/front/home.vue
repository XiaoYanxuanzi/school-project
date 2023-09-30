<template>
  <div class="flex-container">
      <el-card class="box-card">
        <el-result title="打卡按钮" subTitle="点击下方按钮进行打卡">
          <template slot="icon">
            <div style="display: flex; align-items: center; cursor: default">
              <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
            </div>
          </template>
          <template slot="extra">
            <el-button type="primary" size="medium" @click="Daka">打卡</el-button>
          </template>
        </el-result>
      </el-card>
      <el-card class="box-card">
<!--        <el-empty description="暂未开发功能"></el-empty>-->
        <el-result title="提问按钮" subTitle="点击下方按钮进行提问">
          <template slot="icon">
            <div style="display: flex; align-items: center; cursor: default">
              <el-avatar icon="el-icon-chat-line-round"></el-avatar>
            </div>
          </template>
          <template slot="extra">
            <el-button type="primary" size="medium" @click="handleAdd">提问</el-button>
          </template>
        </el-result>
      </el-card>

<!--    提问弹窗-->
    <el-dialog title="提问" :visible.sync="fromVisible" width="40%" :close-on-click-modal="false">
      <el-form :model="form" label-width="80px" style="padding-right: 20px" :rules="rules" ref="formRef">
        <el-form-item label="接收人" prop="title">
          <el-select v-model="value" placeholder="请选择老师">
            <el-option
                v-for="item in teacher"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              <span style="float: left">{{ item.label }}</span>
              <span style="float: right; color: #8492a6; font-size: 13px">{{ item.value }}</span>
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="标题"></el-input>
        </el-form-item>

        <el-form-item label="内容" prop="content">
          <el-input type="textarea" v-model="form.content" placeholder="内容"></el-input>
        </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="fromVisible = false">取 消</el-button>
        <el-button type="primary" @click="question">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import request from "@/utils/request";

export default {
  name: "home",
  data() {
    return {
      teacher:[],
      value: '',
      form: {},
      user: JSON.parse(localStorage.getItem('roles') || '{}'),
      fromVisible:false,
      rules: {
        title: [
          { required: true, message: '请输入标题', trigger: 'blur' },
        ],
        content: [
          { required: true, message: '请输入内容', trigger: 'blur' },
        ]
      },

    }
  },
  mounted() {  // 等页面元素全部初始化好
    this.Allteachers();
  },
  methods: {
      //打卡
      Daka(){
        request.post("/student/attendance",this.user).then(res => {
          console.log(this.user.username)
          if (res.code === '200'){
            this.$message.success("打卡成功")
          }else {
            this.$message.error(res.msg)
          }
        })
      },

      handleAdd() {   // 新增数据
        this.fromVisible = true   // 打开弹窗
      },

      //获取老师信息
      Allteachers(){
        request.get("/student/getAll").then(res => {
          console.log(res);
          // 将返回的数据格式转换为选项所需的格式
          this.teacher = res.data.map(item => ({
            value: item.id,
            label: item.nickname
          }));
          console.log(this.teacher);
        })
      },

      //提交信息
      question(){
        request.post("/student/ask").then(res => {
          console.log(res)
          if (res.code === '200'){
            this.$message.success("提问成功")
          }else {
            this.$message.error(res.msg)
          }
        })
      }
  }
}
</script>

<style scoped>

.box-card {
  width: 1519px;
  height: 350px;
}


</style>