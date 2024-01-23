function count(input) {
	let countObj = {};
	input.forEach(ele => {
		// Check whether the ele already exists in the countObj as keys
		if (ele in countObj) {
			countObj[ele] += 1;
		} else {
			countObj[ele] = 1;
		}
	});
	return countObj;
}

let input1 = ["a", "b", "c", "a", "c", "a", "x"];

console.log(count(input1));

function groupByKey(input) {
	let countObj = {};
	input.forEach(ele => {
		if (ele.key in countObj) {
			countObj[ele.key] += ele.value;
		} else {
			countObj[ele.key] = ele.value;
		}
	});
	return countObj;
}

let input2 = [
	{ key: "a", value: 3 },
	{ key: "b", value: 1 },
	{ key: "c", value: 2 },
	{ key: "a", value: 3 },
	{ key: "c", value: 5 }
];

console.log(groupByKey(input2));
