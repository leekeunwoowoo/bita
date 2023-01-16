"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[938],{4938:function(t,e,a){a.r(e),a.d(e,{default:function(){return u}});var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("page-title",{attrs:{heading:t.heading,subheading:t.subheading,icon:t.icon}}),a("b-row",[a("b-col",{attrs:{md:"6"}},[a("b-card",{staticClass:"main-card mb-3",attrs:{title:"Sizing"}},[a("b-pagination",{attrs:{size:"md","total-rows":100,"per-page":10},model:{value:t.currentPage,callback:function(e){t.currentPage=e},expression:"currentPage"}}),a("div",{staticClass:"divider"}),a("b-pagination",{attrs:{size:"sm","total-rows":100,"per-page":10},model:{value:t.currentPage,callback:function(e){t.currentPage=e},expression:"currentPage"}}),a("div",{staticClass:"divider"}),a("b-pagination",{attrs:{size:"lg","total-rows":100,"per-page":10},model:{value:t.currentPage,callback:function(e){t.currentPage=e},expression:"currentPage"}}),a("div",{staticClass:"divider"}),a("div",{staticClass:"text-center"},[t._v(" Current Page: "+t._s(t.currentPage)+" ")])],1)],1),a("b-col",{attrs:{md:"6"}},[a("b-card",{staticClass:"main-card mb-3",attrs:{title:"Navigation"}},[a("h6",[t._v("Default")]),a("b-pagination-nav",{attrs:{"base-url":"#","number-of-pages":10},model:{value:t.currentPage,callback:function(e){t.currentPage=e},expression:"currentPage"}}),a("h6",{staticClass:"mt-4"},[t._v("With link generator function")]),a("b-pagination-nav",{attrs:{"link-gen":t.linkGen,"number-of-pages":10},model:{value:t.currentPage,callback:function(e){t.currentPage=e},expression:"currentPage"}}),a("div",{staticClass:"divider"}),a("div",{staticClass:"text-center"},[t._v(" Current Page: "+t._s(t.currentPage)+" ")])],1)],1)],1),a("b-card",{staticClass:"main-card mb-3",attrs:{title:"Alignments"}},[a("h6",[t._v("Left alignment (default)")]),a("b-pagination",{attrs:{"total-rows":100,"per-page":10},model:{value:t.currentPage,callback:function(e){t.currentPage=e},expression:"currentPage"}}),a("br"),a("h6",[t._v("Center alignment")]),a("b-pagination",{attrs:{align:"center","total-rows":100,"per-page":10},model:{value:t.currentPage,callback:function(e){t.currentPage=e},expression:"currentPage"}}),a("br"),a("h6",[t._v("Right (end) alignment")]),a("b-pagination",{attrs:{align:"right","total-rows":100,"per-page":10},model:{value:t.currentPage,callback:function(e){t.currentPage=e},expression:"currentPage"}}),a("div",{staticClass:"divider"}),a("div",{staticClass:"text-center"},[t._v(" Current Page: "+t._s(t.currentPage)+" ")])],1)],1)},i=[],r=a(47774),s={components:{PageTitle:r.Z},data:function(){return{heading:"Pagination",subheading:"Basic and dynamic pagination for use in your next awesome application.",icon:"pe-7s-notebook icon-gradient bg-mixed-hopes",currentPage:3}},methods:{linkGen:function(t){return"#page/"+t+"/foobar"}}},c=s,l=a(1001),o=(0,l.Z)(c,n,i,!1,null,null,null),u=o.exports},47774:function(t,e,a){a.d(e,{Z:function(){return d}});var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-page-title"},[a("div",{staticClass:"page-title-wrapper"},[a("div",{staticClass:"page-title-heading"},[a("div",{staticClass:"page-title-icon"},[a("i",{class:t.icon})]),a("div",[t._v(" "+t._s(t.heading)+" "),a("div",{staticClass:"page-title-subheading"},[t._v(" "+t._s(t.subheading)+" ")])])]),a("div",{staticClass:"page-title-actions"},[a("button",{staticClass:"btn-shadow mr-3 btn btn-dark",attrs:{type:"button"}},[a("font-awesome-icon",{attrs:{icon:"star"}})],1),a("button",{staticClass:"btn-shadow d-inline-flex align-items-center btn btn-success",attrs:{type:"button"},on:{click:function(e){return t.createEvent()}}},[a("font-awesome-icon",{staticClass:"mr-2",attrs:{icon:"plus"}}),t._v(" Create New ")],1)])])])},i=[],r=a(78947),s=a(51436),c=a(57810);r.vI.add(s.Tab,s.r8p);var l={components:{"font-awesome-icon":c.GN},props:{icon:String,heading:String,subheading:String},methods:{createEvent:function(t){this.$parent.newPop("00001")}}},o=l,u=a(1001),g=(0,u.Z)(o,n,i,!1,null,null,null),d=g.exports}}]);