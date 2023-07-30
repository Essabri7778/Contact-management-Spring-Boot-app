<nav class="navbar navbar-expand-lg navbar-dark px-3 mb-5"
     style="background: linear-gradient(211deg, rgb(253, 112, 136) 0.00%, rgb(255, 211, 165) 100.00%);height: 60px">
    <div class="container-fluid">
        <a href="${pageContext.request.contextPath}/showForm" style="font-family: 'Concert One', cursive; font-size: 30px; text-decoration: none; color: white;padding-bottom: 5px">
            <i class="fa-solid fa-address-book" style="color: #ffffff; width: 16px; margin-right: 20px "></i>ManageConatct</a>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" style="font-size: 18px;"
                    href="${pageContext.request.contextPath}/showForm">Add Contact</a>
                </li>
                <li class="nav-item"><a class="nav-link" style="font-size: 18px;"
                    href="${pageContext.request.contextPath}/manageContacts">Manage
                    Contacts</a>
                </li>
                <li class="nav-item"><a class="nav-link" style="font-size: 18px;"
                    href="${pageContext.request.contextPath}/showGroupForm">Add Groups</a>
                </li>
                <li class="nav-item"><a class="nav-link" style="font-size: 18px;"
                    href="${pageContext.request.contextPath}/manageGroupes">Manage
                    Groups</a>
                </li>
            </ul>
        </div>
    </div>
</nav>