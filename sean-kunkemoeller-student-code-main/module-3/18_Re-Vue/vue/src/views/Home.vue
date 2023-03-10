<template>
  <div class="home">
    <h1>Welcome {{user.username}} </h1>
    <balance />
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>


import Balance from "../components/Balance.vue";
import TenmoService from '../services/TenmoService';

export default {
  name: "home",
  components: {
    Balance
  },
  data() {
    return {
      user: {
        username: "",
        balance: ""
      }
    }
  },
  methods: {
    
  },
  created() {
      TenmoService.getCurrentUser().then((response) => {
        this.user.username = response.data.username;
      })
  }
    
}

</script>

<style>
.home {
  position: relative;
  top: 10rem;
  background-color: rgba(88, 23, 90, 0.9);
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
#linkToBalance{
  height: 50px;
  width: 200px;
  background-color: rgb(156, 92, 156);
  border-radius: 5px;
  text-align: center;
  text-decoration: none;
  padding-top: 2rem;
}
#linkToBalance:hover{
   background-color: rgb(173, 132, 173);
}
</style> (edited) 
