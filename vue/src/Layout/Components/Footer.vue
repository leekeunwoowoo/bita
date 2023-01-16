<template>
    <div class="app-footer">
        <div class="app-footer__inner text-center">
            Copyright 2019 DashboardPack.com
        </div>
        <Toasts class="my-5"
            :show-progress="false"
            :rtl="false"
            :max-messages="15"
            :time-out="2000"
            :closeable="false"
        ></Toasts>
    </div>
</template>

<script>

    import {library} from '@fortawesome/fontawesome-svg-core'
    import { faEllipsisV } from '@fortawesome/free-solid-svg-icons'
    // import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'

    library.add(
        faEllipsisV,
    );
    export default {
        name: "Footer",
        components: {
        }
    };
</script>
