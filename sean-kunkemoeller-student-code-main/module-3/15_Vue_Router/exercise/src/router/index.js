import Vue from 'vue';
import VueRouter from 'vue-router'
import Home from '@/views/Home'
import MyBooks from '@/views/MyBooks'
import NewBook from '@/views/NewBook'
import Details from '@/views/Details';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/myBooks',
    name: 'myBooks',
    component: MyBooks
  },
  {
    path: '/addBook',
    name: 'add-book',
    component: NewBook
  },
  {
    path: '/book/:isbn',
    name: 'Book',
    component: Details
  }
];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
