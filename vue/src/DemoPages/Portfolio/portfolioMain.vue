<template>
  <div>
    <page-title :heading=heading :subheading=subheading :icon=icon></page-title>

      <div class="row" v-for="(item, idx) in list" v-bind:key="`o-${idx}`">

        <div class="col-md-12">
          <div class="ard-shadow-info border border-primary main-card mb-3 card">
            <!--<img width="100%" src="https://placeholdit.imgix.net/~text?txtsize=33&amp;txt=318%C3%97180&amp;w=318&amp;h=180" alt="Card image cap" class="card-img-top">-->
            <div class="card-body">
              <div class="row">
                  <div class="col-md-4 mb-3">
                    <div class="position-relative form-group">
                      <video-player  
                                    class=""
                                    ref="videoPlayer"
                                    :options="playerOptions"
                                    :playsinline="true"
                                    customEventName="customstatechangedeventname"

                                    @play="onPlayerPlay($event)"
                                    @pause="onPlayerPause($event)"
                                    @ended="onPlayerEnded($event)"
                                    @statechanged="playerStateChanged($event)"
                                    @ready="playerReadied">
                      </video-player>
                    </div>
                  </div>
                  <div class="col-md-8">
                    <div class="position-relative form-group">
                      <h5 class="card-title text-truncate">{{ item.PROJ_NM }}</h5><h6 class="card-subtitle text-truncate" >{{ item.SUB_TITLE }}</h6><span class="text-truncate3">{{ item.CNTC}}</span>
                      <br>
                      <button class="btn btn-outline-focus mt-2">Play</button>
                      <button class="btn btn-outline-focus mt-2 ml-2">GoPage</button>
                      <button class="btn btn-outline-focus mt-2 ml-2">DownLoad</button>
                    </div>
                  </div>
                </div>
              </div>
          </div>
        </div>

      </div>
      <b-pagination align="center" :total-rows="totCount" v-model="currentPage" :per-page="12" @change="onPageChange">
      </b-pagination>
    
  </div>
</template>


<script>

  import PageTitle from "../../Layout/Components/PageTitle.vue";
  import ppo from '../../apis/ppo';
  // require styles
  import { videoPlayer } from 'vue-video-player'
  import 'video.js/dist/video-js.css'

  export default {
    components: {
      PageTitle,
      videoPlayer
    },
    data: () => ({
      heading: 'Portfolio',
      subheading: 'Mani\'s video editing portfolio.',
      icon: 'pe-7s-paint-bucket icon-gradient bg-grow-early',
      currentPage: 1,
      idx: 0,
      page: {
        page: 1,
        size: 12,
        sort: "aa,desc",
        keyword: ""
      },
      list: [],
      keyword: "",
      totCount: 0,
      playerOptions: {
          // videojs options
          muted: true,
          language: 'en',
          playbackRates: [0.7, 1.0, 1.5, 2.0, 2.5, 3.0],
          //autoplay: true,
          currentTime : 1000,
          height: '165%',
          sources: [{
            type: "video/mp4",
            src: "https://cdn.theguardian.tv/webM/2015/07/20/150716YesMen_synd_768k_vp8.webm"
          }],
          poster: "/static/images/author.jpg",
          controlBar : {
                playToggle : true,
                pictureInPictureToggle : true,
                remainingTimeDisplay : true,
                progressControl : true,
                durationDisplay: true,
                fullscreenToggle: true //     
            }
        }
    }),
    mounted() {
      //console.log('this is current player instance object', this.player)
    },
    computed: {
      player() {
        return this.$refs.videoPlayer.player
      }
    },
    methods: {
        search() {
            ppo.selPpoList(this.page).then((response) => {
                this.list = response.data.result;
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
        // listen event
        onPlayerPlay(player) {
          //console.log('player play!', player)
          //this.onPlayerPause(player);
        },
        onPlayerPause(player) {
           //console.log('player pause!', player)
        },
        // ...player event

        // or listen state event
        playerStateChanged(playerCurrentState) {
          // console.log('player current update state', playerCurrentState)
        },

        // player is ready
        playerReadied(player) {
          //console.log('the player is readied', player)
          // you can use it to do something...
          // player.[methods]
        }
    },
    created() {
        //console.log(this);
        //toggleBodyClass('closed-sidebar');
        this.search();
    }

  }
</script>
