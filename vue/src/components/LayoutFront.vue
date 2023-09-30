<template>
  <div>
    <!-- 头部区域 -->
    <div style="height: 60px; line-height: 60px; background-color: white; margin-bottom: 2px; display: flex">
      <!-- logo标题 -->
      <div style="width: 300px">
        <img src="@/assets/学生平台logo.png" alt="" style="width: 40px; position: relative; top: 10px; left: 20px">
        <span style="margin-left: 25px; font-size: 24px">校园学生平台</span>
      </div>
      <!-- 头部区域 -->
      <el-menu class="el-menu-demo" mode="horizontal" >
        <el-menu-item index="/">首页</el-menu-item>
        <el-menu-item index="/exam" disabled>在线考试</el-menu-item>
        <el-menu-item index="/person">个人信息</el-menu-item>
        <el-menu-item index="/notice">消息中心</el-menu-item>
      </el-menu>

      <div style="flex: 1; text-align: right; padding-right: 20px">
        <el-dropdown size="medium">
          <span class="el-dropdown-link" style="cursor: pointer">
             <div style="display: flex; align-items: center; cursor: default">
                <img :src="user.avatarUrl || 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'" alt="" style="width: 40px; height: 40px; border-radius: 50%; margin: 0 5px">
                {{user.username}}<i class="el-icon-arrow-down el-icon--right"></i>
              </div>
          </span>
          <el-dropdown-menu slot="dropdown" style="width: 100px; text-align: center">
            <el-dropdown-item>
              <div @click="password">
                修改密码
              </div>
            </el-dropdown-item>
            <el-dropdown-item>
              <div @click="person">
                个人信息
              </div>
            </el-dropdown-item>
            <el-dropdown-item>
              <div @click="logout">
                退出
              </div>
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
    <!-- 主体数据 -->
    <!-- width: 0; 可以限制容器的宽度，不被子元素无限撑开-->
    <div style="flex: 1; width: 0; background-color: white;">
      <router-view />
    </div>
  </div>
</template>

<script>
import Cookies from 'js-cookie'
import request from "@/utils/request";

export default {
  name: "LayoutFront",
  data() {
    return {
      user: JSON.parse(localStorage.getItem('student') || '{}'),
    };
  },
  methods: {
    logout(){
      request.post('/student/logout',this.user).then(res => {
        if (res.code === '200'){
          localStorage.removeItem('student')  // 清除当前的token和用户数据
          this.$router.push('/login')
          this.$message.success('退出成功')
        }
      })
    },
  }
}
</script>

<style scoped>

</style>