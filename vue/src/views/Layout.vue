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
                <img :src="user.avatar || 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'" alt="" style="width: 40px; height: 40px; border-radius: 50%; margin: 0 5px">
                {{user.username}}<i class="el-icon-arrow-down el-icon--right"></i>
              </div>
          </span>
          <el-dropdown-menu slot="dropdown" style="margin-top: -5px">
            <el-dropdown-item><div style="text-align: center;" >修改密码</div></el-dropdown-item>
            <el-dropdown-item><div style="text-align: center;" >个人信息</div></el-dropdown-item>
            <el-dropdown-item><div style="text-align: center;" @click="logout">退出</div></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>


    <!-- 侧边栏和主体 -->
    <div style="display: flex">
      <!-- 侧边栏导航 -->
      <div style="width: 200px; min-height: calc(100vh - 62px); overflow: hidden; margin-right: 2px; background-color: white">
        <el-menu :default-active="$route.path" router class="el-menu-demo" style="margin-bottom: 10px">
          <el-menu-item index="/">
            <i class="el-i"></i>
            <span>首页</span>
          </el-menu-item>

          <el-menu-item index="/data" v-if="user.role === '3'">
            <i class="el-i"></i>
            <span>数据报表</span>
          </el-menu-item>

          <el-menu-item index="/chat" v-if="user.role === '3'">
            <i class="el-i"></i>
            <span>聊天室</span>
          </el-menu-item>

          <el-submenu index="user" v-if="user.role === '3'">
            <template slot="title">
              <i class="el-icon-hot-water"></i>
              <span>用户管理</span>
            </template>
            <el-menu-item index="/addUser">用户添加</el-menu-item>
            <el-menu-item index="/userList">用户列表</el-menu-item>
          </el-submenu>

          <el-submenu index="role" v-if="user.role === '3'">
            <template slot="title">
              <i class="el-icon-user"></i>
              <span>角色管理</span>
            </template>
            <el-menu-item index="/addRole">角色添加</el-menu-item>
            <el-menu-item index="/roleList">角色列表</el-menu-item>
          </el-submenu>

          <el-submenu index="admin" v-if="user.role === '3' ">
            <template slot="title">
              <i class="el-icon-user"></i>
              <span>权限管理</span>
            </template>
            <el-menu-item index="/addAdmin">菜单管理</el-menu-item>
            <el-menu-item index="/adminList">用户权限</el-menu-item>
          </el-submenu>
        </el-menu>
      </div>

      <!-- 主体数据 -->
      <!-- width: 0; 可以限制容器的宽度，不被子元素无限撑开-->
      <div style="flex: 1; width: 0; background-color: white; padding: 10px">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
import Cookies from 'js-cookie'

export default {
  name: "Layout.vue",
  data() {
    return {
      user: JSON.parse(localStorage.getItem('roles') || '{}'),
    }
  },
  methods: {
    logout(){
      localStorage.removeItem('roles')  // 清除当前的token和用户数据
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>

</style>