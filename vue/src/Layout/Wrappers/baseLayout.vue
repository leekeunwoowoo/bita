<template>
    <div class="app-container app-theme-white">
        <transition name="fade" mode="out-in" appear>
            <Header/>
        </transition>
        <transition name="fade" mode="out-in" appear>
            <Sidebar :openState="false" @childState="openState" />
        </transition>
        <div class="app-main__outer">
            <div class="app-main__inner">
                <slot></slot>
            </div>
            <transition name="fade" mode="out-in" appear>
                <Footer/>
            </transition>
        </div>
        <!-- Modal Component -->
        <b-modal id="modal1" title="Bootstrap-Vue">
            <p class="my-4">Hello from modal!</p>
        </b-modal>
        <b-modal id="modallg" size="lg" title="Large Modal">
            Hello Modal!
        </b-modal>
        <b-modal id="modalsm" size="sm" title="Small Modal">
            Hello Modal!
        </b-modal>

        <b-modal 
            centered 
            id="board_insert"
            ref="boardModal"
            v-model="show"
            :title=boardTitle
            :header-bg-variant="headerBgVariant"
            :header-text-variant="headerTextVariant"
            :body-bg-variant="bodyBgVariant"
            :body-text-variant="bodyTextVariant"
            :footer-bg-variant="footerBgVariant"
            :footer-text-variant="footerTextVariant"
        >
            <form ref="form" @submit.stop.prevent="handleSubmit">

                <b-container fluid>

                    <b-row class="my-1">
                        <b-col sm="2">
                            <label for="input-small">분류:</label>
                        </b-col>
                        <b-col sm="10">
                            <b-form-select
                            v-model="selected"
                            :options="options"
                            v-bind:disabled="isReadOnly == 0"
                            ></b-form-select>
                        </b-col>
                    </b-row>
                    <b-row class="my-1">
                        <b-col sm="2">
                            <label for="input-small">제목:</label>
                        </b-col>
                        <b-col sm="10">
                            <b-form-input
                            id="bTitle"
                            v-model="bTitle"
                            :state="bTitleState"
                            placeholder="Insert Title..."
                            required
                            v-bind:disabled="isReadOnly == 0"
                            ></b-form-input>
                        </b-col>
                    </b-row>

                    <b-row class="my-1">
                        <b-col sm="2">
                            <label for="input-small">내용:</label>
                        </b-col>
                        <b-col sm="10">
                            <b-form-textarea
                            id="bContent"
                            v-model="bContent"
                            placeholder="Insert Contents..."
                            rows="3"
                            max-rows="6"
                            v-bind:disabled="isReadOnly == 0"
                            ></b-form-textarea>
                        </b-col>
                    </b-row>
                </b-container>
            </form>

            <template #modal-footer>
                <div class="w-100">
                    <p class="float-left"></p>
                    <b-button
                        variant="light"
                        size="sm"
                        class="float-right ml-1"
                        v-if="btnInsert"
                        @click="show=false"
                        >
                        Cancle
                    </b-button>

                    <b-button
                        variant="light"
                        size="sm"
                        class="float-right"
                        v-if="btnInsert"
                        @click="boardSave()"
                        >
                        Save
                    </b-button>

                    <b-button
                        variant="light"
                        size="sm"
                        class="float-right ml-1"
                        v-if="btnClose"
                        @click="show=false"
                        >
                        close
                    </b-button>

                    <b-button
                        variant="light"
                        size="sm"
                        class="float-right ml-1"
                        v-if="btnReple"
                        @click="repleInsert()"
                        >
                        Reple
                    </b-button>

                </div>
            </template>
        </b-modal>
    </div>
</template>

<script>
    import Header from "../Components/Header";
    import Sidebar from "../Components/Sidebar";
    import Footer from "../Components/Footer";
    import { getComCode } from '../../apis/code_api';
    import { getBoardInsert } from '../../apis/board_api';
    // import VuePerfectScrollbar from 'vue-perfect-scrollbar'

    import {library} from '@fortawesome/fontawesome-svg-core'
    import {
        faCog,
    } from '@fortawesome/free-solid-svg-icons'
    // import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'

    library.add(
        faCog,
    );
    export default {
        name: 'app',
        data() {
            return {
                selected:'00000',
                show: false,
                options: [{text: "게시팡", value: "00000"}],
                //boardClass: 'default',
                headerBgVariant: 'dark',
                headerTextVariant: 'white',
                bodyBgVariant: 'dark',
                bodyTextVariant: 'white',
                footerBgVariant: 'dark',
                footerTextVariant: 'dark',
                bTitle: '',
                bTitleState: null,
                submittedNames: [],
                bContent: '',
                btnInsert: '',
                btnClose: '',
                btnReple: '',
                isReadOnly: '0',
                boardTitle: '',
                codeParam: {
                    code: '',
                    title: '',
                    content: ''
                },
                isOpenState: true,
            }
        },
        components: {
            Header,
            Sidebar,
            Footer,
        },
        methods: {
            boardSave() {
                this.codeParam.code = this.selected;
                this.codeParam.title = this.bTitle;
                this.codeParam.contest = this.bContent;

                /*
                this.$toast.success('your message');
                this.$toast.error('your message');
                this.$toast.warning('your message');
                this.$toast.info('your message');
                */

                console.log(this.codeParam.code);

                if(this.codeParam.code == "") {
                    this.$toast.error('입력할 게시판 선택!');
                    return;
                } else if(this.codeParam.title == "" || this.codeParam.title.length < 5) {
                    this.$toast.error('제목을 5자 이상 입력!');
                    return;
                } else if(this.codeParam.content == "" || this.codeParam.content.length < 10) {
                    this.$toast.error('내용을 10자 이상 입력!!');
                    return;
                }

                getBoardInsert(this.codeParam).then((response) => {
                    if(response.data.rtnCode == "00") {
                        this.$toast.success('저장되었습니다!');
                    } else {
                        this.$toast.warning('저장중 에러 발생!');
                    }
                    this.$refs.boardModal.hide();
                    //this.$parent.search(); 
                });

            },
            getCode() {
                getComCode(this.codeParam).then((response) => {
                    this.reset();
                    const rtnCode = response.data.result;

                    for(let i=0; i<rtnCode.length; i++) {
                        this.options[i] = rtnCode[i];
                        if( i == 0) {
                            this.selected = rtnCode[i].value;
                        }
                    }
                    this.boardTitle = "Board Insert"
                });
            },
            setInsert(code) {
                this.codeParam.code = code;
                this.getCode();
                this.btnController("I");
            },
            setBoardPopData(data) {
                this.codeParam.code = '00002';
                getComCode(this.codeParam).then((response) => {
                    this.options={};
                    const rtnCode = response.data.result;

                    for(let i=0; i<rtnCode.length; i++) {
                        this.options[i] = rtnCode[i];
                    }
                    
                });
                
                this.selected = data.BOARD_CLASS;
                this.bTitle=data.TITLE;
                this.bContent=data.CONTENTS;
                this.btnController("R");

                if(data.REPLE_USE_YN == "Y") {
                    this.btnReple="1";
                }
                console.log(data.REPLE_USE_YN);
            },
            reset() {
                this.boardTitle="";
                this.bTitle="";
                this.bContent="";
                this.options={};
            },
            btnController(state) {
                if(state == "I") {
                    this.btnInsert="1";
                    this.btnClose="";
                    this.isReadOnly = "1";
                    this.btnReple="";
                } else if(state == "R") {
                    this.boardTitle = "Board View"
                    this.btnInsert="";
                    this.btnClose="1";
                    this.isReadOnly = "0";
                    this.btnReple="";
                }
            },
            openState: function(sideState) {
                console.log("baseLayout : " + sideState);
                this.isOpenState=sideState;
                console.log("baseLayout : " + this.isOpenState);
            }
        },
        created() {
        }
    }
</script>
