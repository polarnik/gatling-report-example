var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "907",
        "ok": "464",
        "ko": "443"
    },
    "minResponseTime": {
        "total": "109",
        "ok": "146",
        "ko": "109"
    },
    "maxResponseTime": {
        "total": "11316",
        "ok": "11316",
        "ko": "10139"
    },
    "meanResponseTime": {
        "total": "6318",
        "ok": "6607",
        "ko": "6015"
    },
    "standardDeviation": {
        "total": "3820",
        "ok": "4050",
        "ko": "3539"
    },
    "percentiles1": {
        "total": "8255",
        "ok": "9069",
        "ko": "7946"
    },
    "percentiles2": {
        "total": "9196",
        "ok": "9613",
        "ko": "8478"
    },
    "percentiles3": {
        "total": "10017",
        "ok": "10230",
        "ko": "9204"
    },
    "percentiles4": {
        "total": "10464",
        "ok": "10623",
        "ko": "9722"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 114,
    "percentage": 13
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 3,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 347,
    "percentage": 38
},
    "group4": {
    "name": "failed",
    "count": 443,
    "percentage": 49
},
    "meanNumberOfRequestsPerSecond": {
        "total": "3.628",
        "ok": "1.856",
        "ko": "1.772"
    }
},
contents: {
"req_---get--b702a": {
        type: "REQUEST",
        name: "/ (GET)",
path: "/ (GET)",
pathFormatted: "req_---get--b702a",
stats: {
    "name": "/ (GET)",
    "numberOfRequests": {
        "total": "464",
        "ok": "464",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "146",
        "ok": "146",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "11316",
        "ok": "11316",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "6607",
        "ok": "6607",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "4050",
        "ok": "4050",
        "ko": "-"
    },
    "percentiles1": {
        "total": "9069",
        "ok": "9069",
        "ko": "-"
    },
    "percentiles2": {
        "total": "9613",
        "ok": "9613",
        "ko": "-"
    },
    "percentiles3": {
        "total": "10230",
        "ok": "10230",
        "ko": "-"
    },
    "percentiles4": {
        "total": "10623",
        "ok": "10623",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 114,
    "percentage": 25
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 3,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 347,
    "percentage": 75
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.856",
        "ok": "1.856",
        "ko": "-"
    }
}
    },"req_-40x-html--get--737c9": {
        type: "REQUEST",
        name: "/40x.html (GET)",
path: "/40x.html (GET)",
pathFormatted: "req_-40x-html--get--737c9",
stats: {
    "name": "/40x.html (GET)",
    "numberOfRequests": {
        "total": "443",
        "ok": "0",
        "ko": "443"
    },
    "minResponseTime": {
        "total": "109",
        "ok": "-",
        "ko": "109"
    },
    "maxResponseTime": {
        "total": "10139",
        "ok": "-",
        "ko": "10139"
    },
    "meanResponseTime": {
        "total": "6015",
        "ok": "-",
        "ko": "6015"
    },
    "standardDeviation": {
        "total": "3539",
        "ok": "-",
        "ko": "3539"
    },
    "percentiles1": {
        "total": "7946",
        "ok": "-",
        "ko": "7946"
    },
    "percentiles2": {
        "total": "8478",
        "ok": "-",
        "ko": "8478"
    },
    "percentiles3": {
        "total": "9204",
        "ok": "-",
        "ko": "9204"
    },
    "percentiles4": {
        "total": "9722",
        "ok": "-",
        "ko": "9722"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 443,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.772",
        "ok": "-",
        "ko": "1.772"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
