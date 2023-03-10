<template>
    <div id="app" class="main">
      <div class="actions">
        <router-link v-bind:to="{name: 'products'}"> Back to Products </router-link>
           | <router-link v-bind:to="{name: 'add-review'}"> Add Review </router-link>
      </div>
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <div class="well-display">
      <average-summary />
      <star-summary rating="1"/>
      <star-summary :rating="2"/>
      <star-summary v-bind:rating="3"/>
      <star-summary rating="4"/>
      <star-summary rating="5"/>
    </div>
    <review-list/>
  </div>
</template>

<script>
import AverageSummary from "../components/AverageSummary.vue";
import StarSummary from "../components/StarSummary.vue";
import ReviewList from '../components/ReviewList.vue';

export default {
 components: {
    AverageSummary,
    StarSummary,
    ReviewList
  },
  computed: {
      product(){
         return this.$store.state.products.find(
             (currentProduct)=>{
                 return currentProduct.id == this.$store.state.activeProduct
             }
         );
      }
  },
  //created is a lifecylce hook we will talk more about on Tuesday - for now now it means 'when the dom is loaded'
  created(){
     const currentActiveProductId = this.$route.params.id;
     this.$store.commit("SET_ACTIVE_PRODUCT", currentActiveProductId);
  }
}
</script>

<style>

</style>