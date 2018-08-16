import request from '@/utils/request'

export function userList() {
  return request({
    url: '/system/userList',
    method: 'get'
  })
}

export function getUserInfoByUserName(userName) {
  return request({
    url: '/system/getUserInfoByUserName',
    method: 'post',
    data: {
      userName
    }
  })
}

// 保存用户
export function saveUserInfo(userInfo) {
  return request({
    url: '/system/saveUserInfo',
    method: 'post',
    data: userInfo
  })
}

export function deleteUserInfo(userId) {
  return request({ url: '/system/deleteUserInfo/' + userId, method: 'get' })
}

