<template>
  <svg
    @click="$emit('cancel-edit')"
    id="cancel"
    viewBox="-2 -2 24 24"
    width="16"
    height="16"
    preserveAspectRatio="xMinYMin"
  >
    <path
      d="M11.414 10l2.829-2.828a1 1 0 1 0-1.415-1.415L10 8.586 7.172 5.757a1 1 0 0 0-1.415 1.415L8.586 10l-2.829 2.828a1 1 0 0 0 1.415 1.415L10 11.414l2.828 2.829a1 1 0 0 0 1.415-1.415L11.414 10zM4 0h12a4 4 0 0 1 4 4v12a4 4 0 0 1-4 4H4a4 4 0 0 1-4-4V4a4 4 0 0 1 4-4z"
    ></path>
  </svg>
</template>

<script>
export default {
  name: 'CancelSVG'
}
</script>

<style scoped>
#cancel {
  fill: red;
  margin-right: 0.5rem;
  cursor: pointer;
}
#cancel:hover {
  fill: #b40000;
}
</style>
