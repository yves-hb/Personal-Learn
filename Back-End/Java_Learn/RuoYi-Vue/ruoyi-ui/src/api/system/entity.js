import request from '@/utils/request'

// 查询人员基本信息列表
export function listEntity(query) {
  return request({
    url: '/system/entity/list',
    method: 'get',
    params: query
  })
}

// 查询人员基本信息详细
export function getEntity(id) {
  return request({
    url: '/system/entity/' + id,
    method: 'get'
  })
}

// 新增人员基本信息
export function addEntity(data) {
  return request({
    url: '/system/entity',
    method: 'post',
    data: data
  })
}

// 修改人员基本信息
export function updateEntity(data) {
  return request({
    url: '/system/entity',
    method: 'put',
    data: data
  })
}

// 删除人员基本信息
export function delEntity(id) {
  return request({
    url: '/system/entity/' + id,
    method: 'delete'
  })
}
