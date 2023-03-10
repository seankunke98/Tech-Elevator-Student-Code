<template>
  <div id="app">
    <product-review/>
      <header-review/>
      
 
  </div>
</template>

<script>
import HeaderReview from './components/HeaderReview.vue'

import ProductReview from './components/ProductReview.vue'

export default {
  name: 'App',
  components: {
    ProductReview,
    HeaderReview
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
