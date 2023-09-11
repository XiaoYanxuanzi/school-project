<template>
  <div>
    <div style="color: #666;font-size: 14px;">
      <div style="padding-bottom: 20px">
        <b>您好！{{user.username}}</b>
      </div>
      <el-card>
        欢迎使用本系统
        <el-divider />
        制作成员：陈明轩，黄玉瑶，林雪微，黄锦源，江小丹
      </el-card>

    </div>
    <el-card>
      <div id="line" style="width: 100%; height: 455px"></div>
    </el-card>
  </div>
</template>

<script>
import Cookies from 'js-cookie'
import request from "@/utils/request";
import * as echarts from 'echarts'

  export default {
    data() {
      return {
        user: JSON.parse(localStorage.getItem('roles') || '{}'),
      }
    },
    mounted() {  // 等页面元素全部初始化好

    },
    methods: {

    }
  }
</script>

<style>
.input {
  width: 300px;
}
</style>
