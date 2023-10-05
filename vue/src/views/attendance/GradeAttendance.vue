<template>
  <div>
    <el-radio-group v-model="timeType">
      <el-radio-button label="day">按天</el-radio-button>
      <el-radio-button label="week">按周</el-radio-button>
    </el-radio-group>
    <el-button @click="getAttendanceByGrade">查询</el-button>
    <div v-if="attendance">
      <p>迟到人数: {{ attendance.lateCount }}</p>
      <p>迟到人名: {{ attendance.lateNames }}</p>
      <p>旷课人数: {{ attendance.absentCount }}</p>
      <p>旷课人名: {{ attendance.absentNames }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Grade",
  data() {
    return {
      timeType: 'day',
      attendance: null
    };
  },
  methods: {
    getAttendanceByGrade() {
      // 发送请求获取年级考勤信息
      // 使用this.timeType作为参数，表示按天或按周查询
      // 将返回的考勤信息赋值给this.attendance
    }
  }
};
</script>
