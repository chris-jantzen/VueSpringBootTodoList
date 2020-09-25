<template>
  <svg
    @click="$emit('save-edit')"
    id="save"
    width="24"
    height="24"
    viewBox="0 0 32 32"
  >
    <path
      d="M12 21.56L6.44001 16L4.55334 17.8867L12 25.3333L28 9.33334L26.1133 7.44667L12 21.56Z"
    ></path>
  </svg>
</template>

<script>
export default {
  name: 'SaveSVG'
}
</script>

<style scoped>
#save {
  cursor: pointer;
  fill: #2bd900;
  margin-right: 0.5rem;
}
#save:hover {
  fill: #1e9400 !important;
}
</style>
