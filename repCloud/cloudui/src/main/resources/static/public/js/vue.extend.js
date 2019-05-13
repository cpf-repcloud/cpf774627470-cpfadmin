/**
 * Created by sing on 2018/7/13.
 */
//分页表格数据查询的混入
Vue.mixin({
    data: function () {
        return {
            ipage: {
                total: 0,
                current: 1,
                size: 20,
                isAsc: true,
                orderByField: ""
            }
        };
    },
    methods: {
        queryPage: function () {
            var params = {}, _this = this;
            $.extend(true, params, {data: this.iquery}, this.ipage);
            this.igrid.loading = true;
            $.ajax({
                type: "POST",
                url: this.igrid.url,
                data: JSON.stringify(params),
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (response) {
                    _this.igrid.loading = false;
                    if (response.status && response.status === "200" && response.result) {
                        _this.pagedata = response.result.records;
                        _this.ipage.total = response.result.total;
                        _this.ipage.size = response.result.size;
                        _this.ipage.current = response.result.current;
                        _this.data = response.result.records;
                        if (_this.gridSuccsess && Object.prototype.toString.call(_this.gridSuccsess) === "[object Function]") {
                            _this.gridSuccsess(response);
                        } else {
                            new Error("please config 'gridSuccsess' methods in your vue instance!");
                        }
                    } else {
                        new Error("please config 'gridSuccsess' methods in your vue instance!");
                    }
                },
                error: function () {
                    _this.igrid.loading = false;
                }
            });
        },
        queryList: function () {   //为了传递无分页的情况
            var params = {}, _this = this;
            $.extend(true, params, this.iquery);
            this.igrid.loading = true;
            $.ajax({
                type: "POST",
                url: this.igrid.url,
                data: JSON.stringify(params),
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (response) {
                    _this.igrid.loading = false;
                    if (_this.gridSuccsess && Object.prototype.toString.call(_this.gridSuccsess) === "[object Function]") {
                        _this.gridSuccsess(response);
                    } else {
                        new Error("please config 'gridSuccsess' methods in your vue instance!");
                    }
                },
                error: function () {
                    _this.igrid.loading = false;
                }
            });
        },
        changePage: function (pageIndex) {
            this.ipage.current = pageIndex;
            this.queryPage();
        },
        changePageSize: function (pageSize) {
            this.ipage.size = pageSize;
            this.changePage(1);
        },
        getUser: function () {
            var _this = this;
            $.ajax({
                url: "/custom/repEmployee/getUser",
                success: function (data) {
                    debugger
                    _this.user = data.result;
                }
            })
        },
        // 获取员工控件信息
        getEmployeeList: function (data) {
            var _this = this;
            if (!data) {
                data = {};
            }
            $.ajax({
                type: "POST",
                url: "/custom/kj/employee/getEmployeeList",
                data: JSON.stringify(data),
                dataType: "json",
                async: true,
                contentType: "application/json;charset=UTF-8",
                success: function (response) {
                    if (response.status && response.status === "200") {
                        var employeeList = response.result;
                        _this.employeeList = employeeList;
                    }
                }
            })
        },
        // 获取城市控件数据
        getCountryList: function (data) {
            var _this = this;
            if (!data) {
                data = {};
            }
            $.ajax({
                type: "POST",
                url: "/custom/country/getCountryList",
                data: JSON.stringify(data),
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (response) {
                    if (response.status && response.status === "200") {
                        _this.countryList = response.result;
                    }

                }
            });
        },
        //获取成本中心控件数据
        getCostconterList: function (data) {
            var _this = this;
            if (!data) {
                data = {};
            }
            $.ajax({
                type: "POST",
                url: "/custom/kj/cost/getCostconterList",
                data: JSON.stringify(data),
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (response) {
                    if (response.status && response.status === "200") {
                        debugger
                        _this.costcenterList = response.result;
                    }

                }
            });
        },
        ///项目控件
        getProjectList: function (data) {
            var _this = this;
            if (!data) {
                data = {};
            }
            $.ajax({
                type: "POST",
                url: "/custom/kj/project/getProjectList",
                data: JSON.stringify(data),
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (response) {
                    if (response.status && response.status === "200") {
                        _this.projectList = response.result;
                        console.log("projectList", _this.projectList)
                    }

                }
            });
        },
        ///部门控件
        getDeptList: function (data) {
            var _this = this;
            if (!data) {
                data = {};
            }
            $.ajax({
                type: "POST",
                url: "custom/kj/dept/getDeptList",
                data: JSON.stringify(data),
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (response) {
                    if (response.status && response.status === "200") {
                        _this.deptList = response.result;
                    }

                }
            });
        },
        //下拉员工控件
        getXlCityList: function (data) {
            debugger
            var _this = this;
            if (!data) {
                data = {};
            }
            $.ajax({
                type: "POST",
                url: "/custom/kj/city/getXlCityList",
                data: JSON.stringify(data),
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (response) {
                    debugger
                    if (response.status && response.status === "200") {
                        debugger
                        _this.cityXlList = response.result;
                    }

                }
            });

        }
    }
});
