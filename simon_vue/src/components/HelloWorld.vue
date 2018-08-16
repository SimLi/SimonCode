<template>
    <div class="hello">
        <el-table :data="bookdata" border>
            <el-table-column label="书名"></el-table-column>
        </el-table>
    </div>
</template>

<script>
import { showBooks } from '@/api/book'
export default {
    name: 'HelloWorld',
    data () {
        return {
            msg: 'Welcome to Your Vue.js App',
            bookdata: []
        }
    },
    created () {
        this.initPage()
    },
    methods: {
        initPage: function () {
            showBooks().then(response => {
                this.bookdata = response.data
            })
        }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
    font-weight: normal;
}

ul {
    list-style-type: none;
    padding: 0;
}

li {
    display: inline-block;
    margin: 0 10px;
}

a {
    color: #42b983;
}
</style>
