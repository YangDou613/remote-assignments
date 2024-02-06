function delayedResultPromise(n1, n2, delayTime) {
	return new Promise(function(resolve, reject) {
		setTimeout(() => {
			resolve(`${n1+n2} (${n1}+${n2})`);
		}, delayTime);
	})
}

delayedResultPromise(4, 5, 3000).then(console.log);

module.exports = {
	delayedResultPromise: delayedResultPromise
};
