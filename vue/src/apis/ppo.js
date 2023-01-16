import request from '../utils/request';

function selPpoList(query) {
    return request({
        url: '/api/ppo/selPpoList',
        method: 'post',
        params: query
    });
}

function selPpoList2(query) {
    return request({
        url: '/api/ppo/selPpoList',
        method: 'post',
        params: query
    });
} 

export default {selPpoList, selPpoList2}