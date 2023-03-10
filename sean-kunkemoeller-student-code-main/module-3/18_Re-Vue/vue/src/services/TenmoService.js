import axios from 'axios';


export default {

    getCurrentUser() {
        return axios.get('/users/current');
    },

    getBalance() {
        return axios.get('/account/balance')
    }

}