<template>
    <div>
        <b-pagination size="lg" align="center" :total-rows="100" v-model="currentPage" :per-page="10" @change="onPageChanges">
        </b-pagination>
    </div>
</template>

<script>

  export default {
    name: 'Pagination',
    props: ['pageChange'],
    data: () => ({
      heading: 'Pagination',
      subheading: 'Basic and dynamic pagination for use in your next awesome application.',
      icon: 'pe-7s-notebook icon-gradient bg-mixed-hopes',

      currentPage: 1
    }),
    computed: {
    },
    methods: {
      onPageChanges(val) {
            const param = {
                requestPage: val,
            };
            this.pageChange(param);
        }
    }
  }
</script>
