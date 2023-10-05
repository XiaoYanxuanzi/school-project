<template>
  <div>
    <el-input v-model="studentId" placeholder="请输入学生学号"></el-input>
    <el-button @click="getAttendanceByStudent">查询</el-button>
    <div v-if="attendance">
      <p>迟到次数: {{ attendance.lateCount }}</p>
      <p>旷课次数: {{ attendance.absentCount }}</p>
    </div>
  </div>
</template>

<script>

export default {
  name: "Student",
  data() {
    return {
      studentId: '',
      attendance: null
    };
  },
  methods: {
    getAttendanceByStudent() {
      // 发送请求获取学生考勤信息
      // 使用this.studentId作为参数
      // 将返回的考勤信息赋值给this.attendance
    }
  }
};
</script>
