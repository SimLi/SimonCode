<template>
  <div class="app-container">
    <el-row>
      <el-col :span="24" class="toolbar-right">
        <el-button type="primary" icon="el-icon-plus" size="mini" @click="addUserClick">新增账户</el-button>
      </el-col>
    </el-row>
    <el-table :data="userList" style="width:100%" size="small" >
      <el-table-column label="ID" prop="id" width="100" align="center"></el-table-column>
      <el-table-column label="用户名" prop="userName" width="200" align="center"></el-table-column>
      <el-table-column label="邮箱" prop="email"  align="center"></el-table-column>
      <el-table-column label="手机" prop="phoneNum" width="150" align="center"></el-table-column>
      <el-table-column label="办公电话" prop="officNum" width="150" align="center"></el-table-column>
      <el-table-column label="创建日期" prop="createDate" width="150" align="center" >
        <template slot-scope="scope">
          {{scope.row.createDate | parseTime}}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" @click="editUserClick(scope.row)" size="mini" ></el-button>
          <el-button type="danger" icon="el-icon-delete" @click="deleteUserClick(scope.row, scope.$index)" size="mini" ></el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 账户编辑对话框 -->
    <user-edit :user-name="userName" :visible="userEditVisble" :edit-type="userEditType" 
      v-on:dialogCancelClick="userEditCancel" v-on:dialogConfirmClick="userEditConfirm" ></user-edit>
  </div>
</template>

<script>
import { userList, deleteUserInfo } from '@/api/setting/user'
import userEdit from './userEdit'

export default {
  components: { userEdit },
  data() {
    return {
      userList: [],
      userName: '',
      userPageModel: '',
      userEditVisble: false,
      userEditType: 'edit'
    }
  },

  created() {
    this.initPage()
  },

  methods: {
    initPage: function() {
      userList().then(response => {
        this.userList = response.data
      })
    },

    // 新增账户
    addUserClick: function() {
      this.userEditType = 'add'
      this.userName = ''
      this.userEditVisble = true
    },

    editUserClick: function(userInfo) {
      this.userEditType = 'edit'
      this.userPageModel = userInfo
      this.userName = userInfo.userName
      this.userEditVisble = true
    },

    deleteUserClick: function(userInfo, index) {
      this.$confirm('此操作将删除改条记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteUserInfo(userInfo.id).then(response => {
          if (response.code === 200) {
            this.userList.splice(index, 1)
            this.$message({
              message: '删除成功',
              type: 'success'
            })
          } else {
            this.$message.error('操作失败')
          }
        })
      })
    },

    // 编辑取消
    userEditCancel: function() {
      this.userEditVisble = false
    },

    // 编辑确定
    userEditConfirm: function(userInfo) {
      if (this.userEditType === 'edit') {
        Object.assign(this.userPageModel, userInfo)
        this.userEditVisble = false
      } else {
        console.log('adduser', userInfo)
        this.userList.push(userInfo)
      }
    }

  }
}
</script>

