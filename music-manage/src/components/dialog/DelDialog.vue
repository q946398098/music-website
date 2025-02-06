<script setup lang="ts">

import {getCurrentInstance, ref, toRefs, watch} from "vue";

const { proxy } = getCurrentInstance();


const props = defineProps({
  delVisible: {
    type: Boolean,
    default: true
  },
})

const { delVisible } = toRefs(props);

const centerDialogVisible = ref(delVisible.value);

function cancelRow() {
  proxy.$emit("cancelRow", false);
}

function confirm() {
  proxy.$emit("confirm", null);
}

watch(delVisible, (value) => {
  centerDialogVisible.value = value;
});



</script>

<template>
 <div>
   <el-dialog title="提示" v-model="centerDialogVisible" width="300px" center>
     <div class="del-dialog-cnt" align="center">删除不可恢复，是否确定删除？</div>
     <template #footer>
        <span class="dialog-footer">
          <el-button @click="cancelRow">取 消</el-button>
          <el-button type="primary" @click="confirm">确 定</el-button>
        </span>
     </template>
   </el-dialog>
 </div>
</template>

<style scoped lang="scss">

</style>