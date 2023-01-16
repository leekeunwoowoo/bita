import request from '../utils/request';

function getBoardInsert(param){

    return request({
        url:'/api/board/boardInsert',
        method: 'POST',
        params: param
    });
}

export {getBoardInsert}
