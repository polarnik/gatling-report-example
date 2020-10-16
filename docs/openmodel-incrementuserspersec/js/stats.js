var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1560",
        "ok": "482",
        "ko": "1078"
    },
    "minResponseTime": {
        "total": "106",
        "ok": "142",
        "ko": "106"
    },
    "maxResponseTime": {
        "total": "60003",
        "ok": "59757",
        "ko": "60003"
    },
    "meanResponseTime": {
        "total": "18140",
        "ok": "14427",
        "ko": "19800"
    },
    "standardDeviation": {
        "total": "17408",
        "ok": "14298",
        "ko": "18391"
    },
    "percentiles1": {
        "total": "15004",
        "ok": "13383",
        "ko": "15005"
    },
    "percentiles2": {
        "total": "19662",
        "ok": "20042",
        "ko": "19147"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "50620",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "58529",
        "ko": "60001"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 110,
    "percentage": 7
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 8,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 364,
    "percentage": 23
},
    "group4": {
    "name": "failed",
    "count": 1078,
    "percentage": 69
},
    "meanNumberOfRequestsPerSecond": {
        "total": "5.132",
        "ok": "1.586",
        "ko": "3.546"
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
        "total": "780",
        "ok": "482",
        "ko": "298"
    },
    "minResponseTime": {
        "total": "142",
        "ok": "142",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60003",
        "ok": "59757",
        "ko": "60003"
    },
    "meanResponseTime": {
        "total": "19460",
        "ok": "14427",
        "ko": "27601"
    },
    "standardDeviation": {
        "total": "18996",
        "ok": "14298",
        "ko": "22508"
    },
    "percentiles1": {
        "total": "13107",
        "ok": "13383",
        "ko": "10003"
    },
    "percentiles2": {
        "total": "20402",
        "ok": "20042",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "50620",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "58529",
        "ko": "60002"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 110,
    "percentage": 14
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 8,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 364,
    "percentage": 47
},
    "group4": {
    "name": "failed",
    "count": 298,
    "percentage": 38
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2.566",
        "ok": "1.586",
        "ko": "0.98"
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
        "total": "780",
        "ok": "0",
        "ko": "780"
    },
    "minResponseTime": {
        "total": "106",
        "ok": "-",
        "ko": "106"
    },
    "maxResponseTime": {
        "total": "60001",
        "ok": "-",
        "ko": "60001"
    },
    "meanResponseTime": {
        "total": "16820",
        "ok": "-",
        "ko": "16820"
    },
    "standardDeviation": {
        "total": "15549",
        "ok": "-",
        "ko": "15549"
    },
    "percentiles1": {
        "total": "15005",
        "ok": "-",
        "ko": "15005"
    },
    "percentiles2": {
        "total": "18890",
        "ok": "-",
        "ko": "18890"
    },
    "percentiles3": {
        "total": "57526",
        "ok": "-",
        "ko": "57526"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "-",
        "ko": "60001"
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
    "count": 780,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2.566",
        "ok": "-",
        "ko": "2.566"
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
