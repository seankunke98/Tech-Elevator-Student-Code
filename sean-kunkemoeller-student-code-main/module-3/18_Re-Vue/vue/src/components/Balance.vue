<template>
  <div class= "balance">
      <p>Your balance is: {{balance}}</p>
  </div>
</template>

<script>

import TenmoService from "../services/TenmoService.js";


export default {
    data() {
        return {
            balance: Number,
        }
        
    },

created() {
TenmoService.getBalance().then((response) => {
    if(response.status == 200) {
    this.balance = response.data;
    }
})
}
    

}
</script>

<style>

</style>