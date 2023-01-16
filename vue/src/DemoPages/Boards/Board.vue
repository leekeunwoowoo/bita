<template>
    <div class="tableDiv">
        <Pagination :currentPage="currentPage" :totalPages="totalPages" :pageChange="pageChange" />
    </div>
</template>

<script>


export default {
    name: 'Table',
    components: { Pagination }
}
</script>
