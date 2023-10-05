<template>
  <div class="container">
    <el-row justify="center">
      <el-col :span="3" v-for="(student, index) in seats" :key="student.id">
        <div class="seat" @click="handleSeatClick(index)">
          <span>{{ student.name }}</span>
          <el-dropdown>
        <span class="el-dropdown-link">
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>提问</el-dropdown-item>
              <el-dropdown-item>xxx</el-dropdown-item>
              <el-dropdown-item>xxx</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </el-col>
    </el-row>

    <el-row justify="center">
      <el-col :span="3">
        <div class="seat">
            {{user.username}}
          </div>
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
      user: JSON.parse(localStorage.getItem('teacher') || '{}'),
      seats: [
        { name: '张三' },
        { name: '李四' },
        { name: '王五' },
        { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
        { name: '李四' },
        { name: '王五' }, { name: '张三' },
      ]
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
  line-height: 95px;
  margin-bottom: 20px;
  background-color: #f5f5f5;
}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.center-row {
  justify-content: center;
}
</style>
