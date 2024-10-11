let LinkId = 0;
        function addLink() {
            const LongUrl = document.getElementById('LongUrl').value;
            const Short_url = document.getElementById('Short_url').value;
            
            if (LongUrl === '' || Short_url === '') return;
            const data = {
                "longUrl": LongUrl,
                "short_url": Short_url 
            };


            LinkId++;
            const table = document.getElementById('LinkTable');
            const row = table.insertRow();
            row.setAttribute('id', `Link-${LinkId}`);

            row.innerHTML = `
                <td>${LinkId}</td>
                <td>${LongUrl}</td>
                <td>http://localhost:8080/api/${Short_url}</td>
            `;
            const myHeaders = new Headers();
            myHeaders.append("Content-Type", "application/json");

            const raw = JSON.stringify({
                "longUrl": LongUrl,
                "short_url": Short_url 
            });
            const requestOptions = {
                method: "POST",
                headers: myHeaders,
                body: raw,
                redirect: "follow"
            };

            fetch("http://localhost:8080/api/links", requestOptions)
                .then(function (response) { console.log(response.text()) })
                .then(function (result) { console.log(result) })
                .catch((error) => console.error(error));

            document.getElementById('LongUrl').value = '';
            document.getElementById('Short_url').value = '';
            
        }

        
