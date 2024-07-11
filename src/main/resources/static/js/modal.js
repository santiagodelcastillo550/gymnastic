function showModal(element) {
    const nombre = element.textContent;
    const descripcion = element.getAttribute('data-descripcion');
    const series = element.getAttribute('data-series');
    const repeticiones = element.getAttribute('data-repeticiones');

    document.getElementById('modal-nombre').textContent = nombre;
    document.getElementById('modal-descripcion').textContent = descripcion;
    document.getElementById('modal-series').textContent = series;
    document.getElementById('modal-repeticiones').textContent = repeticiones;

    document.getElementById('modal').style.display = 'block';
}

function closeModal() {
    document.getElementById('modal').style.display = 'none';
}