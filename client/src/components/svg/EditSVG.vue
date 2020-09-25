<template>
  <svg width="16" height="16" viewBox="0 0 24 24" fill="none">
    <path
      d="M14.76 4.44L19.56 9.24L4.8 24H0V19.2L14.76 4.44ZM16.44 2.76L19.2 0L24 4.8L21.24 7.56L16.44 2.76Z"
      fill="#4FCAFE"
    ></path>
  </svg>
</template>

<script>
export default {
  name: 'EditSVG'
}
</script>

<style scoped>
#edit {
  cursor: pointer;
  margin-right: 0.75rem;
}
#edit:hover path {
  fill: #3b94b9;
}
</style>
