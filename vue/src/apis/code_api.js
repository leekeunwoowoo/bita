//import Send from "@/apis/common_api";
import request from '../utils/request';

function getComCode(param){
    return request({
        url:'/api/comCode/',
        method:'POST',
        params: param
    });
}

export {getComCode}
