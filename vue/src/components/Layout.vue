<template>
  <div>
    <!-- 头部区域 -->
    <div style="height: 60px; line-height: 60px; background-color: white; margin-bottom: 2px; display: flex">
      <div style="width: 300px">
        <img src="@/assets/logo.png" alt="" style="width: 40px; position: relative; top: 10px; left: 20px">
        <span style="margin-left: 25px; font-size: 24px">课堂教学管理系统</span>
      </div>
      <div style="flex: 1; text-align: right; padding-right: 20px">
        <el-dropdown size="medium">
          <span class="el-dropdown-link" style="cursor: pointer">
             <div style="display: flex; align-items: center; cursor: default">
                <img :src="user.avatarUrl || 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'" alt="" style="width: 40px; height: 40px; border-radius: 50%; margin: 0 5px">
                {{user.nickname}}<i class="el-icon-arrow-down el-icon--right"></i>
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


    <!-- 侧边栏和主体 -->
    <div style="display: flex">
      <!-- 侧边栏导航 -->
      <div style=" overflow: hidden; margin-right: 2px; background-color: white">
        <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
          <el-radio-button :label="false">展开</el-radio-button>
          <el-radio-button :label="true">收起</el-radio-button>
        </el-radio-group>
        <el-menu :default-active="$route.path" router class="el-menu-vertical-demo" :collapse="isCollapse">
          <el-menu-item index="/">
            <i class="el-icon-platform-eleme"></i>
            <span>首页</span>
          </el-menu-item>

          <el-menu-item index="/data">
            <i class="el-icon-pie-chart"></i>
            <span>数据报表</span>
          </el-menu-item>

          <el-menu-item index="/chat" >
            <i class="el-icon-chat-line-round"></i>
            <span>聊天信息</span>
          </el-menu-item>

          <el-submenu index="user">
            <template slot="title">
              <i class="el-icon-user"></i>
              <span>学生管理</span>
            </template>
            <el-menu-item index="/addStudent">学生添加</el-menu-item>
            <el-menu-item index="/studentList">学生列表</el-menu-item>
          </el-submenu>

          <el-submenu index="role">
            <template slot="title">
              <i class="el-icon-s-custom"></i>
              <span>教师管理</span>
            </template>
            <el-menu-item index="/addTeacher">教师添加</el-menu-item>
            <el-menu-item index="/teacherList">教师列表</el-menu-item>
          </el-submenu>

          <el-submenu index="check">
            <template slot="title">
              <i class="el-icon-date"></i>
              <span>考勤记录</span>
            </template>
            <el-menu-item index="/attendance1">查看学生</el-menu-item>
            <el-menu-item index="/attendance2">查看班级</el-menu-item>
            <el-menu-item index="/attendance3">查看年级</el-menu-item>
            <el-menu-item index="/attendance4">查看专业</el-menu-item>
          </el-submenu>

        </el-menu>
      </div>

      <!-- 主体数据 -->
      <!-- width: 0; 可以限制容器的宽度，不被子元素无限撑开-->
      <div style="flex: 1; width: 0; background-color: white;">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
import Cookies from 'js-cookie'
import request from "@/utils/request";

export default {
  name: "Layout.vue",
  data() {
    return {
      user: JSON.parse(localStorage.getItem('teacher') || '{}'),
      isCollapse: true
    }
  },
  methods: {
    logout(){
      request.post('/student/logout',this.user).then(res => {
        if (res.code === '200'){
          localStorage.removeItem('teacher')  // 清除当前的token和用户数据
          this.$router.push('/login')
          this.$message.success('退出成功')
        }
      })
    },

    password(){
      this.$router.push('/password')
    },

    person(){
      this.$router.push('/person')
    },
  }
}
</script>

<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}

.el-icon-arrow-down {
  font-size: 12px;
}
</style>