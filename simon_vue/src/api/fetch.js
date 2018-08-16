import axios from 'axios'
import { Message } from 'element-ui'
import qs from 'qs'
const service = axios.create({
    baseURL: process.env.BASE_API,
    timeout: process.env.timeout,
    transformRequest: [function (data) {
        data = qs.stringify(data)
        return data
    }]
})

service.interceptors.request.use(config => {
    return config
}, erro => {
    Promise.reject(erro)
})
service.interceptors.response.use(
    req => {
        const res = req.data
        if (res.result === false) {
            if (res.msg) {
                Message({
                    message: res.msg,
                    type: 'error',
                    duration: 5 * 1000
                })
            } else {
                Message({
                    message: '数据请求出现错误',
                    type: 'error',
                    duration: 5 * 1000
                })
            }
        } else {
            return req.data
        }
    },
    function (error) {
        return Promise.reject(error)
    }
)
export default service
