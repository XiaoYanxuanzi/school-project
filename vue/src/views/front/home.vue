<template>
<div>
  <el-row>
    <el-button icon="el-icon-search" circle @click="Daka"></el-button>
    <el-button type="primary" icon="el-icon-edit" circle></el-button>
    <el-button type="success" icon="el-icon-check" circle></el-button>
    <el-button type="info" icon="el-icon-message" circle></el-button>
    <el-button type="warning" icon="el-icon-star-off" circle></el-button>
    <el-button type="danger" icon="el-icon-delete" circle></el-button>
  </el-row>
</div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "home",
  data() {
    return {
      user: JSON.parse(localStorage.getItem('roles') || '{}'),
    }
  },
  mounted() {  // 等页面元素全部初始化好

  },
  methods: {
      Daka(){
        request.post("/student/insert",this.user).then(res => {
          console.log(this.user.username)
          if (res.code === '200'){
            this.$message.success("打卡成功")
          }else {
            this.$message.error(res.msg)
          }
        })
      }

  }
}
</script>

<style scoped>

</style>