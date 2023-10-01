<template>
  <div>
    <el-row>
      <el-col :span="3" v-for="seat in 40">
        <div class="seat"></div>
      </el-col>
    </el-row>

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
.seat {
  width: 100px;
  height: 95px;
  border: 1px solid #ccc;
  text-align: center;
  line-height: 100px;
  margin-bottom: 20px;
}
</style>
