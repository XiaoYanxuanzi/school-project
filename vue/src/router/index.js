import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../components/Layout.vue'
import Cookies from "js-cookie";
import LayoutFront from "@/components/LayoutFront";

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Register.vue')
  },
  {
    path: '*',
    name: '404',
    meta: { name: '无法访问' },
    component: () => import('../views/404.vue')
  },
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: '/home',
    children: [  // 子路由
      {
        path: 'home',
        name: 'Home',
        component: () => import('@/views/home/HomeView.vue'),
      },
      {
        path: 'data',
        name: 'data',
        component: () => import('@/views/data/data.vue'),
      },
      {
        path: 'chat',
        name: 'Notice',
        component: () => import('@/views/chat/notice.vue'),
      },
      {
        path: 'studentList',
        name: 'Student',
        component: () => import('@/views/student/student.vue'),
      },
      {
        path: 'addStudent',
        name: 'AddStudent',
        component: () => import('@/views/student/AddStudent.vue'),
      },
      {
        path: 'editStudent',
        name: 'EditStudent',
        component: () => import('@/views/student/EditStudent.vue'),
      },
      {
        path: 'teacherList',
        name: 'Teacher',
        component: () => import('@/views/teacher/teacher.vue'),
      },
      {
        path: 'addTeacher',
        name: 'AddTeacher',
        component: () => import('@/views/teacher/AddTeacher.vue'),
      },
      {
        path: 'editTeacher',
        name: 'EditTeacher',
        component: () => import('@/views/teacher/EditTeacher.vue'),
      },
      {
        path: 'person',
        name: 'Person',
        component: () => import('@/views/home/Person.vue'),
      },
      {
        path: 'password',
        name: 'Password',
        component: () => import('@/views/home/Password.vue'),
      },
      {
        path: 'attendance1',
        name: 'Student',
        component: () => import('@/views/attendance/StudentAttendance'),
      },{
        path: 'attendance2',
        name: 'Password',
        component: () => import('@/views/attendance/ClassAttendance'),
      },{
        path: 'attendance3',
        name: 'Password',
        component: () => import('@/views/attendance/GradeAttendance'),
      },{
        path: 'attendance4',
        name: 'Password',
        component: () => import('@/views/attendance/MajorAttendance'),
      },
    ]
  },
  {
    path: '/front',
    name: 'LayoutFront',
    component: LayoutFront,
    redirect: '/home',
    children: [  // 子路由
      {
        path: 'home',
        name: 'home',
        component: () => import('@/views/front/home.vue'),
      },
      {
        path: 'notice',
        name: 'Notice',
        component: () => import('@/views/front/bar/notice.vue'),
      },
      {
        path: 'person',
        name: 'person',
        component: () => import('@/views/front/bar/person'),
      },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// router.beforeEach((to, from, next) => {
//   if (to.path === '/login') next()
//   const admin = Cookies.get("admin")
//   if (!admin && to.path !== '/login') return next("/login")  // 强制退回到登录页面
//   // 访问 /home 的时候，并且cookie里面存在数据，这个时候我就直接放行
//   next()
// })

export default router
