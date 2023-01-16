<template>
	<div>
        <page-title :heading=heading :subheading=subheading :icon=icon></page-title>
        <b-card title="" class="main-card ">
                
            <b-input-group>
                <b-dropdown text="Dropdown" variant="info" slot="prepend" v-for="i in 1" :key="i">
                    <b-dropdown-item>Action A</b-dropdown-item>
                    <b-dropdown-item>Action B</b-dropdown-item>
                </b-dropdown>
                <input type="text" v-model="keyword" placeholder="search keyword.." class="form-control" @keyup.enter="keywordSearch()">
                <div class="input-group-append">
                    <button class="btn btn-success" @click="keywordSearch()">Search</button>
                </div>
            </b-input-group>
        </b-card>
        <b-card class="main-card mb-4">
            <b-table 
                    striped hover 
                    :items="items"
                    :small="small"
                    style="cursor: pointer;"
                    @row-clicked="toBoardDtlView"
                    :fields="fields"
                    >
            </b-table>
            <b-pagination align="center" :total-rows="totCount" v-model="currentPage" :per-page="10" @change="onPageChange">
            </b-pagination>

        </b-card>        
    </div>
</template>

<script>
//import Table from './Board.vue';
//import pagination from './Pagination';
import board from '../../apis/post';
import PageTitle from "../../Layout/Components/PageTitle.vue";

export default {
    name: 'BoardMain',
    components: {
      PageTitle
    },
    data: () => ({
      heading: 'Qna Board',
      subheading: 'This is a question and answer board.',
      icon: 'pe-7s-drawer icon-gradient bg-happy-itmeo',
      currentPage: 1,
      fields: [ 'RNUM', 'TITLE', 'CREATE_DT', 'HIT' ],
      items: [
      ],
      striped: false,
      bordered: false,
      outlined: false,
      small: false,
      hover: false,
      dark: false,
      fixed: false,
      footClone: false,
      page: {
        page: 1,
        size: 10,
        sort: "aa,desc",
        keyword: ""
      },
      keyword: "",
      totCount: 0
    }),

    methods: {
        toBoardDtlView(item, index, event) {
            this.$toast.info('상세조회를 시작합니다!');
            board.boardDtlSearch(item).then((response) => {    
                this.$parent.$refs.boardModal.show();
                this.$parent.setBoardPopData(response.data.result);

            }).then( response => {
            }).catch( error => {
                this.$toast.warning('조회중 에러 발생!');
            }).then(() => {
            });
        },
        keywordSearch() {
            this.page.keyword = this.keyword;
            this.currentPage = 1;
            this.page.page = 1;
            this.search();
        },
        search() {
            board.boardList(this.page).then((response) => {
                this.items = response.data.result;
                this.totCount = response.data.totCount;
            }).then( response => {
                this.$toast.success('리스트가 조회되었습니다!');
            }).catch( error => {
                this.$toast.warning('리스트 조회중 에러 발생!');
            }).then(() => {
            });
        },
        onPageChange(value) {
            this.page.page = value;
            this.search();
        },
        onSortChange(event) {
            this.sortHeader = event.target.value;
            this.page.sort = this.sortHeader + ',' + this.sortDirection;
            this.search();
        },
        onSortDirectionChange(event) {
            this.sortDirection = event.target.value;
            this.page.sort = this.sortHeader + ',' + this.sortDirection;
            this.search();
        },
        newPop() {
            this.$toast.info('게시글 입력 팝업 실행!');
            this.$parent.$refs.boardModal.show();
            this.$parent.setInsert('00002');

        }
    },
    created() {
        //console.log(this);
        //toggleBodyClass('closed-sidebar');
        this.search();
    }
  }
</script>
