<template>
  <div>
    <review-display
      v-for="currentReview in filterReviews"
      v-bind:key="currentReview.title"
      v-bind:review="currentReview"
    />
  </div>
</template>

<script>
import ReviewDisplay from "./ReviewDisplay.vue";

export default {
  name: "review-list",
  components: {
    ReviewDisplay,
  },
  computed: {
    filterReviews() {
        const reviewsFilter = this.$store.state.filter;
        const reviews = this.$store.state.reviews;
      return reviews.filter((review) => {
        return reviewsFilter === 0
          ? true
          : reviewsFilter === review.rating;
      });
    },
  },
};
</script>

<style>
</style>