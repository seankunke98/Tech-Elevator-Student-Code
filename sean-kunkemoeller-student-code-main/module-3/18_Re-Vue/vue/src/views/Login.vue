<template>
  <div id="app">
    <div id="nav">
      <router-link class="routerLink" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp; &nbsp;
      <router-link class="routerLink" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>
<style>
 #app{
   font-family:Verdana, Geneva, Tahoma, sans-serif;
   color: rgb(180, 180, 200);
 }
 .routerLink{
   color: rgb(150, 150, 180);
   font-size: 1.5rem;
 }
 .component-main {
  position: relative;
  top: 10rem;
  background-color: rgba(88, 23, 90, 0.9);
  border-radius: 5px;
}
</style> (edited) 

<style>
#login{
  margin-top: 80px;
}
#container {
  display: flex;
  justify-content: space-around;
}
.form-control {
  margin-left: 8px;
  height: 25px;
}
h1 {
  margin-left: 10px;
}
#regLink {
  color: rgb(180, 180, 200);
  margin-left: 8px;
}
#submitBtn{
  width: 150px;
}
</style> (edited) 
