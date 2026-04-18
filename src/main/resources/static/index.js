const BASE_URL = "http://localhost:8080/api/images";

// Generate Image
$("#generateBtn").click(function () {
    let prompt = $("#generatePrompt").val();

    if (!prompt) {
        alert("Enter a prompt");
        return;
    }

    $("#generateLoader").show();
    $("#generateResult").html("");

    $.ajax({
        url: BASE_URL + "/generate",
        type: "POST",
        data: { prompt: prompt },

        success: function (response) {
            $("#generateResult").html(
                `<p class="card">Result: </p><img src="${response.url}" />`
            );
        },

        error: function (xhr) {
            let err = xhr.responseJSON;
            $("#generateResult").html(
                `<p style='color:red;'>${err?.error || "Error generating image"}</p>`
            );
        },

        complete: function () {
            $("#generateLoader").hide();
        }
    });
});

