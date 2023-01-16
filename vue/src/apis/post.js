import request from '../utils/request';

function boardList(query) {
    return request({
        url: '/api/board/boardList',
        method: 'post',
        params: query
    });
}

function boardDtlSearch(query) {
    return request({
        url: '/api/board/boardDtlSearch',
        method: 'post',
        params: query
    });
} 

export default {boardList, boardDtlSearch}