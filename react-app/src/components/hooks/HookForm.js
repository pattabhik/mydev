import React, { useState } from "react"

function HookForm() {
  const [userForm, updateUserForm] = useState({ firstName: "", lastName: "" })

  return (
    <form>
      First name:
      <input
        type="text"
        value={userForm.firstName}
        onChange={(e) =>
          updateUserForm({ ...userForm, firstName: e.target.value })
        }
      />
      <br />
      Last name:
      <input
        type="text"
        value={userForm.lastName}
        onChange={(e) =>
          updateUserForm({ ...userForm, lastName: e.target.value })
        }
      />
      <br />
      First name: {userForm.firstName}, Last name: {userForm.lastName}
      <br />
      {JSON.stringify(userForm)}
    </form>
  )
}

export default HookForm
