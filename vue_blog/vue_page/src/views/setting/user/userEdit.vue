<template>
  <el-dialog title="账户编辑" :visible.sync="dialogVisible" width="400">
    <div>
      <el-form :model="userInfo" label-width="80px" >
        <el-form-item label="用户名" prop="userName" v-if="editType === 'edit' ">
          {{userInfo.userName}}
        </el-form-item>
        <el-form-item label="用户名" prop="userName" v-if="editType === 'add' ">
          <el-input v-model="userInfo.userName" style="width:80%" maxlength="8"></el-input>
        </el-form-item>
        <el-form-item label="中文名" prop="chineseName">
          <el-input v-model="userInfo.chineseName" style="width:80%" maxlength="8"></el-input>
        </el-form-item>
        <el-form-item label="邮 箱" prop="email">
          <el-input v-model="userInfo.email" style="width:80%" maxlength="8"></el-input>
        </el-form-item>
        <el-form-item label="手 机" prop="phoneNum">
          <el-input v-model="userInfo.phoneNum" style="width:80%" maxlength="14"></el-input>
        </el-form-item>
        <el-form-item label="固 话" prop="officeNum">
          <el-input v-model="userInfo.officeNum" style="width:80%" maxlength="12"></el-input>
        </el-form-item>
        <el-form-item label="创建日期" prop="createDate">
          <el-date-picker v-model="userInfo.createDate" type="date" format="yyyy-MM-dd" 
           value-format="timestamp"></el-date-picker>
        </el-form-item>
      </el-form>
    </div>
    <span slot="footer" class="dialog-footer">
      <el-button @click="dialogCancelClick">取 消</el-button>
      <el-button type="primary" @click="dialogConfirmClick">确 定</el-button>
    </span>
  </el-dialog>
</template>

<script>
import { getUserInfoByUserName, saveUserInfo } from '@/api/setting/user'

export default {
  data() {
    return {
      userInfo: {},
      dialogVisible: false
    }
  },

  props: {
    userName: {
      type: String,
      default: ''
    },
    visible: {
      type: Boolean,
      default: false
    },
    editType: {
      type: String,
      default: 'edit'
    }
  },

  watch: {
    visible: function(newValue, oldValue) {
      if (newValue) {
        this.dialogVisible = newValue
        if (this.userName) {
          this.getUserInfo(this.userName)
        } else {
          this.userInfo = {}
        }
      }
    }
  },

  methods: {
    // 查询用户信息
    getUserInfo: function(userName) {
      getUserInfoByUserName(this.userName).then(response => {
        this.userInfo = response.data
      })
    },

    // 取消
    dialogCancelClick: function() {
      this.dialogVisible = false
      this.$emit('dialogCancelClick')
    },

    // 确定
    dialogConfirmClick: function() {
      saveUserInfo(this.userInfo).then(response => {
        if (response.code === 200) {
          this.dialogVisible = false
          this.$emit('dialogConfirmClick', response.data)
        }
      })
    }
  }
}
</script>

