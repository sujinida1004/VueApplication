import axios from 'axios';

const BASE_URL = "https://jsonplaceholder.typicode.com/";
// const BASE_LOCAL_API_URL = "http://localhost:8010/api/";
const BASE_LOCAL_API_URL = "/api/board";

export default {

    // Article 가상데이터 호출
    getArticle: function(id) {
        console.log(id);
        return axios.get(BASE_URL + `posts/${id}`);
    },
    getArticles: function(page) {
        console.log(page);
        return axios.get(BASE_URL + 'posts');
    },

    // Local Board 호출
    getBoardList: function(page) {
        console.log(page);
        return axios.get(BASE_LOCAL_API_URL);
    },
    getBoard: function(id) {
        console.log(id);
        return axios.get(BASE_LOCAL_API_URL + `/${id}`);
    },
    postBoard: function(title, contents, reg_id) {
        return axios.post(BASE_LOCAL_API_URL + '/regist',
            {
                title: title,
                contents: contents,
                reg_id: reg_id,
            });
    },
    patchBoard: function(id, title, contents) {
        return axios.patch(BASE_LOCAL_API_URL + `/modify/${id}`,
            {
                title: title,
                contents: contents,
            });
    },

}

