<template>
  <div id="categories">
    <router-link to="" class="category-link">
      <slot name="categories"></slot>
    </router-link>
  </div>
</template>

<script>
    export default {
        name: "categories"
    }
</script>

<style scoped>
  #categories{
    width: 100%;
    height: 50px;
    margin-top: 5px;
    display: flex;
    flex-direction: row-reverse;
  }
  .category-link{
    text-decoration: none;
    display: flex;
    flex-direction: row;
  }
</style>
